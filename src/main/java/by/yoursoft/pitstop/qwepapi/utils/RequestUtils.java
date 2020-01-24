package by.yoursoft.pitstop.qwepapi.utils;

import by.yoursoft.pitstop.qwepapi.exception.QwepBadResponseException;
import by.yoursoft.pitstop.qwepapi.exception.QwepNetworkException;
import by.yoursoft.pitstop.qwepapi.exception.QwepTokenNotValidException;
import by.yoursoft.pitstop.qwepapi.response.BaseResponse;
import by.yoursoft.pitstop.qwepapi.response.Error;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class RequestUtils {
    public static String makeErrorMessage(List<Error> errors) {
        StringBuilder result = new StringBuilder();

        errors.forEach(__ -> result.append(__.getCode()).append(":").append(__.getMessage()).append("\n"));

        return result.toString();
    }

    public static boolean hasErrorCode(List<Error> errors, Long errorCode) {
        if (errors == null) {
            return false;
        }

        return errors.stream().anyMatch(__ -> __.getCode() == errorCode);
    }

    private static <R, T extends BaseResponse<R>> T handleResponse(Response<T> response) throws IOException {
        if (!response.isSuccessful()) {
            throw new QwepNetworkException("qwep.connection.error: " + response.code() + " " + response.message());
        }

        if (response.body() != null) {
            BaseResponse<R> responseBody = response.body();

            if (hasErrorCode(responseBody.getErrors(), 103L)) {
                throw new QwepTokenNotValidException(makeErrorMessage(responseBody.getErrors()));
            }

            if (responseBody.getErrors() != null) {
                throw new QwepBadResponseException(makeErrorMessage(responseBody.getErrors()));
            }

            return response.body();
        }

        return null;
    }

    public static <Q, T extends BaseResponse<Q>, R> T execute(ThrowingIOExceptionFunction<R, Response<T>> executor, R request) {
        try {
            return handleResponse(executor.apply(request));
        } catch (IOException e) {
            throw new QwepNetworkException("qwep.connection.error", e);
        }
    }

    public static <Q, T extends BaseResponse<Q>> T execute(ThrowingIOExceptionSupplier<Response<T>> executor) {
        try {
            return handleResponse(executor.get());
        } catch (IOException e) {
            throw new QwepNetworkException("qwep.connection.error", e);
        }
    }

    @FunctionalInterface
    public interface ThrowingIOExceptionSupplier<T> extends Supplier<T> {

        @Override
        default T get(){
            try{
                return getThrows();
            } catch (IOException e){
                throw new QwepNetworkException("qwep.connection.error", e);
            }
        }

        T getThrows() throws IOException;
    }

    @FunctionalInterface
    public interface ThrowingIOExceptionFunction<T,R> extends Function<T,R> {

        @Override
        default R apply(T t){
            try{
                return applyThrows(t);
            } catch (IOException e){
                throw new QwepNetworkException("qwep.connection.error", e);
            }
        }

        R applyThrows(T t) throws IOException;
    }
}
