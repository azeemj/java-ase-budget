# java-ase-budget

1. POST Method    http://localhost:9191/add-category

Request body:
{

"name":"Salary"

}

Response:
{
content:{
    "id": 2,
    "name": "Salary"
}
status:true
}




2.Remove categories  Delete  http://localhost:9191/delete-categories/{id}

Response:
{
   status:true
}



3.Add budge ,POST Method    http://localhost:9191/add-budget

Request body:
{

"cat_id":12,
"amount":2500

}

Response:
{
content:{
   "cat_id":12,
  "amount":2500
}
status:true
}


4. Add transaction by category ID ,POST , http://localhost:9191/add-transaction

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
}
status:true
}


5.Remove transactoin by tranaction_id

Delete  http://localhost:9191/delete-taransaction/{id}

Response:
{
   status:true
}



