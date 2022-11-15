# API for MenuHub website
## Version: 1.0.0

**Contact information:**  
gitlanm@gmail.com  

**License:** [GPLv3](https://www.gnu.org/licenses/gpl-3.0.en.html)

[See our source code](https://github.com/5anji/PBMenu)
### /restaurant

#### GET
##### Summary:

Show all restaurants

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| pages | query | The number of pages | Yes | integer |
| nrOfItems | query | The numbers of items to return | Yes | integer |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid status value |
| 404 | Not found |

#### POST
##### Summary:

Add retaurant to remote DB

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid status value |
| 404 | Not found |

### /restaurant/{restaurantId}

#### GET
##### Summary:

Find restaurant by ID

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| restaurantId | path | ID of restaurant to return | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid ID supplied |
| 404 | Not found |

#### DELETE
##### Summary:

Delete restaurant by ID

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| restaurantId | path | ID of restaurant to return | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid ID supplied |
| 404 | Not found |

#### PUT
##### Summary:

Update restaurant status

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| restaurantId | path | ID of restaurant to return | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid ID supplied |
| 404 | Not found |

### /restaurant/{restaurantId}/food

#### GET
##### Summary:

Return array of food

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| restaurantId | path | ID of restaurant to return | Yes | string (uuid) |
| pages | query | The number of pages | Yes | integer |
| nrOfItems | query | The numbers of items to return | Yes | integer |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid ID supplied |
| 404 | Not found |

### /restaurant/{restaurantId}/subsidiary

#### GET
##### Summary:

Return array of subsidiaries

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| restaurantId | path | ID of restaurant to return | Yes | string (uuid) |
| pages | query | The number of pages | Yes | integer |
| nrOfItems | query | The numbers of items to return | Yes | integer |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid ID supplied |
| 404 | Not found |

### /restaurant/{restaurantId}/drink

#### GET
##### Summary:

Return array of drinks

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| restaurantId | path | ID of restaurant to return | Yes | string (uuid) |
| pages | query | The number of pages | Yes | integer |
| nrOfItems | query | The numbers of items to return | Yes | integer |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid ID supplied |
| 404 | Not found |

### /food

#### GET
##### Summary:

Get array of food

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| pages | query | The number of pages | Yes | integer |
| nrOfItems | query | The numbers of items to return | Yes | integer |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid status value |
| 404 | Not found |

#### POST
##### Summary:

Add food to DB

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid status value |
| 404 | Not found |

### /food/{foodId}

#### DELETE
##### Summary:

Delete food from DB

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| foodId | path | ID of food to return | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid status value |
| 404 | Not found |

#### GET
##### Summary:

Get a food

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| foodId | path | ID of food to return | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid status value |
| 404 | Not found |

#### PUT
##### Summary:

Update food on DB

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| foodId | path | ID of food to return | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid status value |
| 404 | Not found |

### /subsidiary

#### POST
##### Summary:

Add subsidiary to DB

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid status value |
| 404 | Not found |

### /subsidiary/{subsidiaryId}

#### PUT
##### Summary:

Update subsidiary in DB

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| subsidiaryId | path | ID of subsidiary to return | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid status value |
| 404 | Not found |

#### GET
##### Summary:

Get a specific subsidiary

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| subsidiaryId | path | ID of subsidiary to return | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid status value |
| 404 | Not found |

### /drink

#### POST
##### Summary:

Add drink to DB

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid status value |
| 404 | Not found |

### /drink/{drinkId}

#### DELETE
##### Summary:

Delete drink from DB

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| drinkId | path | ID of the drink | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid status value |
| 404 | Not found |

#### GET
##### Summary:

Get drink from DB

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| drinkId | path | ID of the drink | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid status value |
| 404 | Not found |

#### PUT
##### Summary:

Update drink in DB

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| drinkId | path | ID of the drink | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | successful operation |
| 400 | Invalid status value |
| 404 | Not found |
