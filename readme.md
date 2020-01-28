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
         String apiKey = "F3F6FC0D38B8AFDCB888";
         String applicationNum = "1";
 
         String token = "2338cff301f54753364a88697573ced1e1698ca6";
 
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