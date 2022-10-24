# Description of Back-End
***
## Restaurants Endpoints

This directory represents all the endpoints of restaurant entities. All endpoints
get in touch with restaurant table from the DataBase, also it may make some updates in 
it or process the data that comes from it. *@RequestMapping("api/tablo/restaurant")* is 
the path to the **RestaurantController**. Next there is a brief explanation of all endpoints:

* **/get-all-restaurants**: 
  * **Method:** getAllRestaurants
  * **HTTP Method:** GET
  * **Returns:** List\<[RestaurantsGetResponseDto](https://github.com/5anji/PBMenu/blob/back/back/tablo/src/main/java/com/menius/tablo/entities/response/RestaurantsGetResponseDto.java)>
  * **Map type:** GetMapping
  * **Response Status:** 202 *(ACCEPTED)*
  * **Parameters:**
    * *pages* - integer
    * *nrOfItems* - integer  
  * **Description:** gets all the restaurants in our database and displaying them on the site. 

* **/save-restaurant** 
  * **Method:** saveRestaurant
  * **HTTP Method:** PUT
  * **Returns:** void
  * **Map type:** PutMapping
  * **Response Status:** 201 *(CREATED)*
  * **Parameters:** 
    * *restaurantID* - UUID
    * *restaurantName* - String
    * *restaurantPhoto* - String
    * *restaurantStatus* - enum
  * **Description:** acknowledges when a restaurant has been added to the Database. By default, its status is active.

* **/delete-restaurant**:
    * **Method:** deleteRestaurant
    * **HTTP Method:** DELETE
    * **Returns:** void
    * **Map type:** DeleteMapping
    * **Response Status:** 200 *(OK)*
    * **Parameters:**
        * *restaurantId* - UUID
    * **Description:** acknowledges when a restaurant has been deleted from the DataBase.

* **/get-restaurant-by-id**:
    * **Method:** getRestaurant
    * **HTTP Method:** GET
    * **Returns:** Object [RestaurantsGetResponseDto](https://github.com/5anji/PBMenu/blob/back/back/tablo/src/main/java/com/menius/tablo/entities/response/RestaurantsGetResponseDto.java)
    * **Map type:** GetMapping
    * **Response Status:** 302 *(FOUND)*
    * **Parameters:**
        * *restaurantId* - UUID
    * **Description:** returns the requested restaurant.

* **/detach-restaurant**:
    * **Method:** detachRestaurant
    * **HTTP Method:** POST
    * **Returns:** void
    * **Map type:** PostMapping
    * **Response Status:** 200 *(OK)*
    * **Parameters:**
        * *restaurantId* - UUID
    * **Description:** hides the selected restaurant from the list
      but does not delete it, or it starts displaying it again.

## Subsidiaries Endpoints