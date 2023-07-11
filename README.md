
Scope:
The expense tracking and budgeting application designed and developed by your team
should do the following:
1. Allow a user to see a list of recent transactions
2. Allow a user to enter a new transaction. At a minimum, this should include amount,
whether it is an income or expense transaction and which category it falls under. A
more advanced application will allow the user to enter a note and to specify whether
it is recurring)
3. Allow the user to edit/delete transactions
4. Allow the user to see a list of categories. The application should come with some
preset categories. An advanced application will allow the user to add new
categories.
5. Allow the user to enter a budget, specifying amounts for each category.
6. Allow the user to track their progress against their budget by seeing how much they
have spent in each category against the budget for that category, as well as overall
spending against the overall budget.
The user interface and menu should be console-based and use a simple character-based
menu system (this is to simplify the code so that Visual C++ GUI programming is not
needed).
Important note: you do not need to use a database for this coursework. Although,
ordinarily, you would use a database or some other persistent store to keep data, this
coursework only requires you to simulate the use of a database – either through the use of a
dummy class, flat files etc



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




2.Remove categories  Delete  http://localhost:9191/category/{id}

Response:
{
   status:true
}



3.Add budget ,POST Method    http://localhost:9191/budget
Note:Assumption ,budget allow monthly 

Request body:
{

"cat_id":12,
"amount":2500
"datetime":"2021-01"
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
"frequency":"weekly",
//monthly,every-two-weeks,annualy,everyday
"transaction_type":2 //1- income ,2-expenses 
 "created_at":"datetime"
 "updated_at":datetime"
}
status:true
}


