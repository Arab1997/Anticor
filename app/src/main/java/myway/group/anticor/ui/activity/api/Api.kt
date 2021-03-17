package myway.group.anticor.ui.activity.api




interface Api {

  /*  @POST("auth/login")
    suspend fun login(@Body signInRequest: SignInRequest): SignInResponse*/

  /*  @GET("provinces")
    suspend fun getProvinces(@Query("_lang") lang: String = ""): BaseProvincesResponse<Province>

    @GET("provinces/{province_id}/regions")
    suspend fun getRegions(
        @Path("province_id") provinceId: Long,
        @Query("_lang") lang: String = ""
    ): BaseProvincesResponse<Region>

    @POST("auth/register")
    suspend fun register(@Body registerRequest: RegisterRequest): RegisterResponse

    @POST("auth/register/confirm")
    suspend fun confirmNumber(@Body confirmRequest: ConfirmRequest): ConfirmResponse

    @POST("auth/password/send")
    suspend fun sendToken(@Body sendTokenRequest: SendTokenRequest): SendTokenResponse

    @POST("auth/password/verify")
    suspend fun verifyToken(@Body confirmRequest: ConfirmRequest): VerifyTokenResponse

    @POST("auth/password/reset")
    suspend fun resetPassword(@Body resetPasswordRequest: ResetPasswordRequest): ConfirmResponse

    @GET("categories")
    suspend fun getCategories(@Query("_lang") lang: String): CategoryResponse

    @GET("top-courses")
    suspend fun getTopCourses(@Query("_lang") lang: String): TopCoursesResponse

    @GET("categories/{id}/subcategories")
    suspend fun getSubcategories(@Path("id", encoded = true) id: Long,@Query("_lang") lang: String): SubcategoryResponse

    @GET("categories/top-courses")
    suspend fun getCategoriesTopCourses(@Query("_lang") lang: String): CategoryTopCourseResponse

    @GET("categories/{id}/courses")
    suspend fun getCoursesbyCategory(
        @Path("id") categoryId: Long,
        @Query("page") page: Int = 1,
        @Query("_lang") lang: String
    ): CoursesByCategoryResponse

    @GET("/courses/{id}")
    suspend fun getCourseInfo(@Path("id") courseId: Long,@Query("_lang") lang: String): CourseInfoResponse

    @GET("/subscription/details")
    suspend fun getSupscriptionType(
        @Query("subscription_type") subscriptionType: String,
        @Query("resource_id") courseId: Long,
        @Query("_lang") lang: String
    ): CourseSubscriptionResponse

    @POST("courses/search")
    suspend fun searchCourse(
        @Body searchRequest: SearchRequest,
        @Query("page") page: Int = 1,
        @Query("_lang") lang: String
    ): SearchResponse

    @GET("courses/{id}/videos")
    suspend fun getCourseVideos(@Path("id") courseId: Long): CourseVideoResponse

    @GET("videos/{id}/comments")
    suspend fun getVideoComments(
        @Path("id") videoId: Long,
        @Query("page") page: Int = 1
    ): CommentsResponse*/
}