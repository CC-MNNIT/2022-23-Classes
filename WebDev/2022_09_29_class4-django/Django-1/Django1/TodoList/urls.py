from django.urls import path
from . import views

urlpatterns =[
    path('',views.todo_home,name='todo_home'),
    path('add-item/',views.todo_add,name='todo-add'),
    path('remove-item/<item>/',views.todo_delete,name='todo-delete'),
]
