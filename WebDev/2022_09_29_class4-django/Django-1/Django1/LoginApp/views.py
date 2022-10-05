from django.shortcuts import render,HttpResponse,redirect

# Create your views here.
def home_view(request):
    user = request.COOKIES.get('username')
    if user is None:
        return render(request, 'login_home.html')
    else:
        context={}
        context['user'] = user
        response = render(request, 'login_profile.html', context=context)
        return response

def login_view(request):
    user = request.COOKIES.get('username')
    if user is None:
        username = request.POST.get('username')
        response = redirect('home_view')
        if username is not None:
            response.set_cookie('username',username)
        return response
    else:
        return redirect('home_view')

def logout_view(request):
    response = redirect('login_view')
    response.delete_cookie('username')
    return response
