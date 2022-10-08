from django.shortcuts import render,HttpResponse
from .data import blogs
# Create your views here.

def blog_list_view(request):
    blogs_list = []
    context={}

    # for blog in blogs:
    #     blogs_list.append(blog["title"])

    context["blogs"] = blogs
    return render(request,'blog_indexss.html',context=context)

def blog_detail_view(request,title):

    context={}
    target_blog = None

    for blog in blogs:
        if blog["title"] == title:
            target_blog = blog

    context["blog"] = target_blog
    return render(request,'blog_detail.html',context=context)

def test_home(request):
    return render(request,'about.html')
