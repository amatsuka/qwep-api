Пример реализации неизменяемого хранилища токена

     @RequiredArgsConstructor
     public static class ImmutableStorage implements QwepTokenStorage {
 
         private final String token;
 
         @Override
         public void setToken(String token) {
             /*empty*/
         }
 
         @Override
         public String getToken() {
             return token;
         }
 
         @Override
         public void removeToken() {
             /*empty*/
         }
     }
     
Пример использования API

         String baseUrl = "http://userapi.qwep.ru";
         String apiKey = "sample_api_key";
         String applicationNum = "1";
 
         String token = "sample_access_token";
 
         BaseQwepFactoryConfig baseQwepFactoryConfig = new BaseQwepFactoryConfig();
         baseQwepFactoryConfig
                 .setApplicationNum(applicationNum)
                 .setAuthorizationCode(apiKey)
                 .setBaseUrl(baseUrl)
                 .setTokenStorage(new ImmutableStorage(token))
                 .setHttpInterceptors(asList(new HttpLoggingInterceptor()));
 
         QwepApiFactory qwepApiFactory = new QwepApiFactory(baseQwepFactoryConfig);
         QwepApiSearchService service = new QwepApiSearchService(qwepApiFactory);
 
         SearchRequestBuilder builder = service.searchRequestBuilder()
                 .setArticle("01244")
                 .setBrand("Febi")
                 .setSorts(asList(new SearchSort()
                         .setSort("setArticle")
                         .setType(ESearchSortType.ITEMS)
                         .setOrder(ESearchSortOrder.ASC)));
 
         SearchResponseBody search = service.search(builder);