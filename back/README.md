# Description of Back-End

## Restaurants Endpoints

This directory represents all the endpoints of restaurant entities. All endpoints
get in touch with restaurant table from the DataBase, also it may make some updates in 
it or process the data that comes from it. *@RequestMapping("api/tablo/restaurant")* is 
the path to the **RestaurantController**. Next there is a brief explanation of all endpoints:

<details>
  <summary>/get-all-restaurants</summary>

* **Method:** getAllRestaurants
* **HTTP Method:** GET
* **Returns:** List\<[RestaurantsGetResponseDto](https://github.com/5anji/PBMenu/blob/back/back/tablo/src/main/java/com/menius/tablo/entities/response/RestaurantsGetResponseDto.java)>
* **Map type:** GetMapping
* **Response Status:** 202 *(ACCEPTED)*
* **Parameters:**
  * *pages* - integer
  * *nrOfItems* - integer  
* **Description:** gets all the restaurants in our database and displaying them on the site. 

</details>

<details>
  <summary>/save-restaurant</summary>

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

</details>

<details>
  <summary>/delete-restaurant</summary>

* **Method:** deleteRestaurant
* **HTTP Method:** DELETE
* **Returns:** void
* **Map type:** DeleteMapping
* **Response Status:** 200 *(OK)*
* **Parameters:**
    * *restaurantId* - UUID
* **Description:** acknowledges when a restaurant has been deleted from the DataBase.

</details>

<details>
  <summary>/get-restaurant-by-id</summary>

* **Method:** getRestaurant
* **HTTP Method:** GET
* **Returns:** Object [RestaurantsGetResponseDto](https://github.com/5anji/PBMenu/blob/back/back/tablo/src/main/java/com/menius/tablo/entities/response/RestaurantsGetResponseDto.java)
* **Map type:** GetMapping
* **Response Status:** 302 *(FOUND)*
* **Parameters:**
    * *restaurantId* - UUID
* **Description:** returns the requested restaurant.

</details>

<details>
  <summary>/detach-restaurant</summary>

* **Method:** detachRestaurant
* **HTTP Method:** POST
* **Returns:** void
* **Map type:** PostMapping
* **Response Status:** 200 *(OK)*
* **Parameters:**
    * *restaurantId* - UUID
* **Description:** hides the selected restaurant from the list but does not delete it, or it starts displaying it again.

</details>

## Subsidiaries Endpoints

## Food Endpoints

## Drinks Endpoints

