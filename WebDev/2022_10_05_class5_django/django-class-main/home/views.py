from django.conf import Settings, settings
from django.shortcuts import render, redirect, HttpResponseRedirect, reverse
from django.http import HttpResponse
from django.contrib.auth.models import User

from django.http import JsonResponse


from django.contrib.auth import login, authenticate, logout
from django.contrib.auth.models import User

from django.conf import settings


from .models import Profile


def home(request):
    user = request.user
    if user.is_authenticated:
        return redirect('dashboard')

    return render(request, 'home/index.html')


def dashboard(request):
    user = request.user
    if user.is_authenticated:
        cur_user = Profile.objects.get(email=user.email)
        name = cur_user.name
        email = cur_user.email
        city = cur_user.city

        info = {
            'name': name,
            'email': email,
            'city': city
        }
        return render(request, 'home/dashboard.html', info)

    return redirect('home')


def login_user(request):
    user = request.user
    if user.is_authenticated:
        return redirect('dashboard')

    if request.method == 'GET':
        return render(request, 'home/login.html')

    email = request.POST.get('email', "")
    password = request.POST.get('password', "")

    is_user = User.objects.filter(username=email)

    if len(is_user) == 0:
        return redirect('signup')

    user = authenticate(username=email, password=password)

    if user:
        login(request, user)

        if email == settings.ADMIN_USERNAME:
            print("admin logging in")
            return redirect('admin_dashboard')
        print("not admin login")
        return redirect('dashboard')

    return render(request, 'home/login.html')


def admin_dashboard(request):
    user = request.user
    if user.is_authenticated:
        all_users = Profile.objects.all()

        info = {
            'all_users': all_users
        }

        return render(request, 'home/admin_dashboard.html', info)

    return redirect('home')


def signup(request):
    user = request.user
    if user.is_authenticated:
        return redirect('dashboard')

    if request.method == 'GET':
        return render(request, 'home/signup.html')

    name = request.POST.get('name', "")
    email = request.POST.get('email', "")
    city = request.POST.get('city', "")
    password = request.POST.get('password', "")

    new_user = User.objects.create_user(
        username=email, email=email, password=password)

    new_user.first_name = name
    new_user.save()

    user = authenticate(username=email, password=password)

    Profile(name=name, email=email, city=city).save()

    if user:
        login(request, user)
        return redirect('login')

    return redirect('home')


def logout_user(request):
    logout(request)
    return redirect('home')


def delete_user(request):
    user = request.user
    if user.is_authenticated and user.username == settings.ADMIN_USERNAME:
        email = request.GET.get('id')
        profile_obj = Profile.objects.get(email=email)
        user_obj = User.objects.get(email=email)

        user_obj.delete()
        profile_obj.delete()

        return JsonResponse({})

    return redirect('home')
