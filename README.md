## Android-Github-Search
#### Description
Android application that searches for repository from Github using [Github Search API](https://docs.github.com/en/rest/search) from user input

#### Tech Stacks
* MVVM
* DataBinding
* ViewBinding
* Coroutine Flow
* Hilt
* Retrofit2
* KTX
* LiveData

#### Project directory
```
Android-Github-Search
app
├─ java  
│  └─ com.jiwon.android_github_search
│     ├─ api
│     │  ├─ services
│     │  │  └─ GithubApiService.kt
│     │  └─ RetrofitAPI.kt  
│     │
│     ├─ data
│     │  ├─ GithubRepository.kt
│     │  ├─ GithubRepositoryOwner.kt
│     │  ├─ GithubRepositoryResponse.kt
│     │  └─ ResponseError.kt 
│     │
│     ├─ di
│     │  ├─ NetworkModule.kt
│     │  └─ RepositoryModule.kt 
│     │
│     ├─ repository
│     │  └─ GithubServiceRepository.kt 
│     │
│     ├─ viewmodels
│     │  └─ GithubViewModel.kt
│     │ 
│     ├─ views  
│     │  ├─ adapters
│     │  │  └─ GithubRepositoryAdapter.kt
│     │  └─ MainActivity.kt 
│     │ 
│     └─ GithubSearchApp.kt           
├─ res    
└─ README.md
```

- api
  - RetrofitAPI.kt
    - defines OkHttpClient and interceptor to be used for api services
  - GithubApiService.kt
    - defines methods, base url and gson to be used for Github search api search 
      ```kotlin
      @GET("search/repositories")
      suspend fun searchRepository(
          @Query("q") query : String
      ) : GithubRepositoryResponse
      ```
- data
  - GithubRepository.kt
    - defines the general information about the repository owner
    - contains deserializer to parse json message into the data type
  - GithubRepositoryOwner.kt
    - defines the information about the repository owner 
    - contains deserializer to parse json message into the data type  
  - GithubRepositoryResponse.kt
    - defines response expected from the GithubSearchAPIService
    - contains deserializer to parse json message into the data type 
  - ResponseError.kt
    - defines error code and error message to be displayed in case error occurs
- di
  - NetworkModule.kt
    - defines dependencies to be injected for network services (REST API) 
  - RepositoryModule.kt
    - defines dependencies to be injected for repository
- repository
  - GithubServiceRepository.kt
    - defines repository methods and means to handle information received from either remote or local data source
      ```kotlin
      suspend fun searchRepository(query : String) = flow {
          val out = api.searchRepository(query)
          emit(out.repositories)
      }
      ```
- viewmodels
  - GithubViewModel.kt
    - defines methods to request information from repository
    - defines livedata to display information on screen  
- views
  - GithubRepositoryAdapter.kt
    - defines viewholder for recyclerview to display repository information
    - defines bindingAdpater to bind livedata to adapter to receive updates 
  - MainActivity.kt
    - find views using viewbinding
    - define actions to be taken by views on callbacks 
    - attach adapter to the recyclerview 
