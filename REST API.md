# Authorization REST API

```http request
POST /register

{
  email, phone, name, role
}

Response:
- 201, {id}
- 400
- 500

{
  error_message: $message
}
```

```http request
POST /login

{
  login,
  password
}

Response:
- 200, {token, expiration}
- 400
- 500

{
  error_message: $message
}
```

# Customer REST API

```http request
GET /orders
```

```
Header:
- x-auth-token: $token

- 200
- 401 (access denied)
- 500
- 400
```

```json
{
  "orders": [
    {
      "id": 1,
      "restraunt": {
        "name": "name"
      },
      "timestamp": "",
      "items": [
        {
          "price": 123,
          "quantity":  123,
          "description":  "description",
          "image": "image_path"
        }
      ]
    }
  ],
  "page_index": 0,
  "page_count": 10
}
```

```http request
GET /order/${id}
```
```status code
- 200
- 400
- 401 (access denied)
- 404
- 500
```

ResponseBody

```json
{
  "id": 1,
  "restraunt": {
    "name": "name"
  },
  "timestamp": 123,
  "items": [
    {
      "price": 123,
      "quantity": 213,
      "description": "desc",
      "image": "image_path"
    }
  ]
}
```

GraphQL
```http request
POST /order
```

```json
{
  "restraunt_id": 1,
  "menu_items": [
    {
      "quantity": 1,
      "menu_item_id": 2
    }
  ]
}
```
Response:

```json
OK

{
  "id": 1,
  "secret_payment_url": "url",
  "estimated_time_of_arrival": 123
}
```

---

# Restaurant REST API

```http request
GET /orders?status=active/complete/denied
```
Response:

```json
{
  "orders": [
    {
      "id": 1,
      "menu_items": [
        {
          "quantity": 1,
          "menu_item_id": 2
        }
      ]
    }
  ],
  "page_index": 0,
  "page_count": 10
}
```

```http request
POST (patch?) /order/${id}/
```

Request body:
```json
{
"order_action": "deny/accept/complete"
}
```
Response:

```
- 200
- 400
- 401 (access denied)
- 403 (forbidden)
- 404
- 500
```

---

# Courier REST API

```http request
GET /deliveries?status=active/complete
```

Response:

```json
{
  "delivery": [
    {
      "order_id": 1,
      "restraunt": {
        "address": "sad",
        "distance": 100
      }
      "customer": {
        "address": "sad",
        "distance": 11
      },
      "payment": 120
    }
  ],
  "page_index": 0,
  "page_count": 10
}
```

Response:
```
- 200
- 400
- 401 (access denied)
- 500
```
---

```http request
POST (patch?) /develiry/${id}/
```

Request body:
```json
{
  "order_action": "accept/complete"
}
```
Response:

```
- 200
- 400
- 401 (access denied)
- 403 (forbidden)
- 404
- 500
```

---

RabbitMQ queue schema (logitics)
```
- Queue (producer, consumer)
- Fanout (?)
- 1 queue - 1 data type (model)
- EMAIL_SENDING_QUEUE, EMAIL_SENDING_QUEUE_V2
- RabbitMQ cookbook, RabbitMQ best practices
```