# java-ase-budget

1. POST Method    http://localhost:9191/category

Request body:
{

"name":"Salary"

}

Response:
{
content:{
    "id": 2,
    "name": "Salary",
    "created_at":"datetime"
    "updated_at":datetime"
}
status:true
}




2.Remove categories  Delete  http://localhost:9191/categories/{id}

Response:
{
   status:true
}



3.Add budge ,POST Method    http://localhost:9191/budget

Request body:
{

"cat_id":12,
"amount":2500

}

Response:
{
content:{
   "cat_id":12,
  "amount":2500,
  "created_at":"datetime"
 "updated_at":datetime"
}
status:true
}


4. Add transaction by category ID ,POST , http://localhost:9191/transaction

Typical transactoin (not recurring)
Request body:
{

"cat_id":12,
"amount":2500,   // note if the ammount is more than zero then it is income ,validation is needed to make sure 
"is_recuuring":false,
"transaction_type":1 //1- income ,2-expenses 
}

Response:
{
content:{
   "cat_id":12,
  "amount":2500,
  "is_recuuring":false,
  "transaction_type":1
  "created_at":"datetime"
 "updated_at":datetime"
}
status:true
}


5.Remove transactoin by tranaction_id

Delete  http://localhost:9191/taransaction/{id}

Response:
{
   status:true
}

6.add recurring expenses ,POST, http://localhost:9191/transaction

Request body:
{

"cat_id":12,
"amount":-5500,   // note if the ammount is more than zero then it is income ,validation is needed to make sure 
"is_recuuring":true,
"start_date":"2022-01-12",
"end_date":"2023-01012",
"frequency":"weekly" //monthly,every-two-weeks,annualy
"transaction_type":2 //1- income ,2-expenses 
}

Response:
{
content:{
   "cat_id":12,
"amount":-5500,   // note if the ammount is more than zero then it is income ,validation is needed to make sure 
"is_recuuring":true,
"start_date":"2022-01-12",
"end_date":"2023-01012",
"frequency":"weekly" //monthly,every-two-weeks,annualy
"transaction_type":2 //1- income ,2-expenses 
 "created_at":"datetime"
 "updated_at":datetime"
}
status:true
}


