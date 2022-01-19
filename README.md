# java-ase-budget

1. POST Method    http://localhost:9191/addcategory

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




2.Remove categories  Delete  http://localhost:9191/deletecategories/{id}

Response:
{
   status:true
}



3.POST Method    http://localhost:9191/addbudget

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
