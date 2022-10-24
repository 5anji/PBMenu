# Description of Back-End
***
## Restaurants Endpoints

This directory represents all the endpoints of restaurant entities. All endpoints
get in touch with restaurant table from the DataBase, also it may make some updates in 
it or process the data that comes from it. The path to the **RestaurantController**
is *@RequestMapping("api/tablo/restaurant")*. Next there is a brief explanation of all
endpoints:

* **/get-all-restaurants**: 
  * **Method:** getAllRestaurants
  * **Returns:** List\<RestaurantsGetResponseDto>
  * **Map type:** GetMapping
  * **Response Status:** 202 *(ACCEPTED)*
  * **Parameters:**
    * *pages* - integer
    * *nrOfItems* - integer  
  * **Description:** gets all the restaurants in our database and displaying them on the site. 

* **/save-restaurant** 
  * **Method:** saveRestaurant
  * **Returns:** void
  * **Map type:** PutMapping,
  * **Response Status:** 201 *(CREATED)*
  * **Parameters:** 
    * *restaurantID* - UUID
    * *restaurantName* - String
    * *restaurantPhoto* - String
    * *restaurantStatus* - enum
  * **Description:** acknowledges when a restaurant has been added to the Database. By default, its status is active.

* **/delete-restaurant**:
    * **Method:** deleteRestaurant
    * **Returns:** void
    * **Map type:** DeleteMapping
    * **Response Status:** 200 *(OK)*
    * **Parameters:**
        * *restaurantId* - UUID
    * **Description:** acknowledges when a restaurant has been deleted from the DataBase.

* **/get-restaurant-by-id**:
    * **Method:** getRestaurant
    * **Returns:** Object
    * **Map type:** GetMapping
    * **Response Status:** 302 *(FOUND)*
    * **Parameters:**
        * *restaurantId* - UUID
    * **Description:** returns the requested restaurant.

* **/detach-restaurant**:
    * **Method:** detachRestaurant
    * **Returns:** void
    * **Map type:** PostMapping
    * **Response Status:** 200 *(OK)*
    * **Parameters:**
        * *restaurantId* - UUID
    * **Description:** hides the selected restaurant from the list
      but does not delete it, or it starts displaying it again.

## Subsidiaries Endpoints