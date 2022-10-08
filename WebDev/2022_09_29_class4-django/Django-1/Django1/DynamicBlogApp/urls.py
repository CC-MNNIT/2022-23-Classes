from django.urls import path
from . import views

urlpatterns =[
    path('list/',views.blog_list_view,name='blog_list'),
    path('<slug:title>/',views.blog_detail_view,name='blog_detail'),
    path('about/',views.test_home,name='about'),
    path('',views.test_home)
]