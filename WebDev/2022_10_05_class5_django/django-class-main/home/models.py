
from datetime import time
from os import stat
from django.db import models
from django.db.models.base import Model
from django.db.models.deletion import CASCADE
from django.utils import timezone
from django.contrib.auth import get_user_model
from django.db.models.fields import NullBooleanField
import pytz
from stripe import max_network_retries


User=get_user_model()

class Profile(models.Model):
    # user = models.ForeignKey(User , on_delete = models.CASCADE)
    email = models.CharField(max_length=50 , default="")
    name = models.CharField(max_length=50 , default="")
    city = models.CharField(max_length=50 , default="")

    
    def __str__(self):
        return  f'{self.email} {self.name}'