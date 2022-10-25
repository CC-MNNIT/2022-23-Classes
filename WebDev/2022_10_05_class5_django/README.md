# Web Development Class - V(Django)

## Web Development Class PPT - VI recording: [Here](Django%20Lecture%202.pdf)

#### October 5, 2022

<div align="center"><h3>Database in Django</h3></div>


### Agenda?
* What is Database?
* Types of Databases.
* Database in Django (sqlite3).
* Models in Django.
* ORM.
* Migrations.
* Admin Panel.


###  Django Models
* Models define the **tables** in the database with help of **Object Oriented Programming**.
* These models are basically **Python classes**, which represent a Table in Database.
* These classes are defined in **models.py** file.
* **Class Variables** of Model (Class) represent **Attributes/Columns** of Table.
* **Instances/Objects** of Model (Class) represent **Rows/Tuple** in Table.

* | Object Oriented Programming | Database |
  | ----- | -------- |
  | Class | Table    |
  | Class Variables | Columns |
  | Instances/Objects of Class | Rows/Tuple in table |

### Example model 

```python
class Question(models.Model):  # Model class from models module is inherited in class Question.
    
    question_text = models.CharField(max_length=1000, verbose_name="Text")

    publication_date = models.DateField(verbose_name="Publication Date")

    def __str__(self):  #  A method is declared so that in admin panel Text of Question is displayed.
        return self.question_text

```

* Note that we have not added **question_id** field. *Why?* This is because for each model, **Django creates a Primary Key by default**. It's name is **id** or **pk**.

* For **Choices** Table, write the following code

```python
class Choice(models.Model):

    choice_text = models.CharField(max_length=200, verbose_name="Choice Text")

    number_of_votes = models.IntegerField(verbose_name="Number of Votes")

    question = models.ForeignKey(Question, on_delete=models.CASCADE)

    def __str__(self):
        return self.choice_text
```

* **models.CASCADE** - **Cascade** means that if a table is deleted, then all it's related from in other tables is also deleted. **Example** - In this case when a **Question** is deleted from database, **Choices** corresponding to that question will also be deleted.

* **models.DO_NOTHING** - In this case on deleting a **Question**, **Choices** related to that question won't be deleted.

* **models.RESTRICT** - This will **not allow** any **Question** to be deleted as long as there is a **Choice** present for that question. If we want to delete the **Question**, firstly we will have to delete all the **Choices** related to that question.

* Now can you relate and see the similarities b/w these **Python classes** and **Database's Tables**?
* Visit this link to see all possible **Field Types** - [Django Models Field Types](https://docs.djangoproject.com/en/3.2/ref/models/fields/#field-types)
* So, are these tables created in the database? *Answer is Not Yet*. 
* This is just the Python Code from which Django will create the tables when we order it to.
* Two remaining steps are - **makemigrations** and **migrate**.
* **makemigrations** - This command orders Django to **write queries for our models** in selected database engine in a python file. In other words, **migration file is created**.
    * Still these tables are **NOT** created in the database.
    * Django has just written the SQL queries for creating the databases in a Python file present under **Migrations** folder.
* **migrate** - This command orders Django to **actually create the tables** in database by running the queries that it created in **makemigrations** step. 
* Now there's one more thing, Django comes with some **preinstalled apps**. Those apps also have some models of thieir own.
* When we install Django, we are already provided with migrations for these Tables. We just need to **migrate** them.
* So, we will follow the following steps
    * Firstly we will create tables for preinstalled Django Apps.
    
    ```
    python manage.py migrate
    ```
    
    * Then we will create migration files for our models defined in **polls** app.
    
    ```
    python manage.py makemigrations polls
    ```
    
    *OR*

    ```
    python manage.py makemigrations
    ```
        
    * Go check in **Migrations** folder of **polls** app, you'll find a file like **0001_initial.py**. *Don't be afraid, you can open that file and see what's inside!*
    * Now finally we will again **migrate**. This will create the Tables Questions and Choices.
    
    ```
    python manage.py migrate
    ```
    
    * To see **migration** i.e. **queries made in migration**, run following command in PyCharm's terminal
    
    ```
    python manage.py sqlmigrate polls 0001_initial
    ```

* So, finally, our tables have been created. *But where's the proof? How do we see the tables?*

### Django Admin Panel
* So now we'll introduce you to one of the most famous feature of Django, the **Django Admin Panel**.
* It is somewhat like **PHPMyAdmin** with better UI and features to manage our database.
* Generally, with other Web Frameworks, developers need to create their own Administration Panel, but Django provides us with inbuilt Admin Panel.
* Start the server

```
python manage.py runserver

```
* Visit `http://127.0.0.1:8000/admin`. A page will open asking for **username** and **password**.
* *What to enter here? We've not created any account yet! Why is it asking for Password?*
* It's because Django does not want **unauthorised visitors** to mess with your tables and databases as it can be catastrophic.
* *So How will you enter into the Admin Panel?* Turn into a **superuser** and Django won't stop you.
* We need to create a **superuser** which can access the Admin Panel without any restrictions. 
* Press `Ctrl + C` to stop the server and run the following command in **PyCharm's terminal**.

```
python manage.py createsuperuser
```

* Enter following details
```
Username: admin
Email: admin@admin.com
Password: 
Password (again):
```
* Now **superuser** have been created successfully. 
* Start the server again and visit `http://127.0.0.1:8000/admin`. Use the credentials of **superuser** to enter into Admin Panel.
* *Do you see Questions and Choices tables? Have you been betrayed?* The answer is **NO**.
* For our tables to appear on Admin Panel, we first need to register them from **admin.py** file.
* Write following code in **project/app/admin.py**

```python

from .models import Model1, Model2

admin.site.register(Model1)
admin.site.register(Model2)
```

* Now, after the server restarts, you'll see that **Questions** and **Choices** table appear in the Admin Panel.
* *Go ahead and add some questions and choices*

### Users Table
* Are you wondering, from where did the **Users** table appear in Django's Admin Panel?
* *Did we create it and forgot?* The answer is obviously **NO**.
* This table was provided to us by Django and was created when we ran the very first **migrate** command.
* I am sure now you're **beginning to realise the power of Django** - you don't even need to create **Users** table for your website, it's already there.
* We will see later how we can save data of users using this **Users** table *(if time permits)*.

### Recap: Steps involed in Making/Editing a Table/Model in Django
* **Step 1 (Declaration)** - We **declare/edit** models in **models.py** file.
* **Step 2 (Activation)** - We run `python manage.py makemigrations` command. Migrated files are created. These files contains queries written by Django in selected Database Engine in a **.py** file.
* **Step 3 (Migration)** - We run `python manage.py migrate` command. Actual Tables/Database is created.
* **Step 4** - Register the models in **admin.py** and visit **Django Admin Panel** to interact with the database.


### Materials

* [Django Video Tutorial Playlist](https://www.youtube.com/watch?v=UmljXZIypDc&list=PL-osiE80TeTtoQCKZ03TU5fNfx2UY6U4p) (English)
* [Django Video Tutorial Playlist](https://www.youtube.com/watch?v=5BDgKJFZMl8&list=PLu0W_9lII9ah7DDtYtflgwMwpT3xmjXY9) (Hindi)
* [Django Models Field Types](https://docs.djangoproject.com/en/3.2/ref/models/fields/#field-types)
* [Python Resources](https://github.com/CC-MNNIT/2021-22-Classes/tree/main/Python)