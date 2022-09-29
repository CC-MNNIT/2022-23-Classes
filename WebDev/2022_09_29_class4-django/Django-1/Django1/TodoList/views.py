from django.shortcuts import render,redirect
from .data import list_items
# Create your views here.
def todo_home(request):
    context={}
    context['list_items']=list_items
    return render(request,'todo_home.html',context=context)

def todo_add(request):
    item = request.GET.get('item')
    list_items.append(item)
    return redirect('todo_home')

def todo_delete(request,item):
    item_to_delete = item
    list_items.remove(item_to_delete)
    return redirect('todo_home')