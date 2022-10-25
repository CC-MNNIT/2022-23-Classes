from django.contrib import admin
from django.urls import path, include
from django.conf.urls import url

from . import views



urlpatterns = [
    
    path('',views.home,name='home'),
    path('dashboard/',views.dashboard,name='dashboard'),
    path('login/',views.login_user,name='login'),
    path('admin_dashboard/',views.admin_dashboard,name='admin_dashboard'),
    path('signup/',views.signup,name='signup'),
    path('logout/',views.logout_user,name='logout'),
    path('delete_user/',views.delete_user,name='delete_user')
]