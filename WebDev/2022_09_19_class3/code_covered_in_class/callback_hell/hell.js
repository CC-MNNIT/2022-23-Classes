const profileComplete = (dog, callback) => {
    // is name attached to profile?
    isNameLoaded(dog, (err, loaded) => {
      if (err) {
        callback(err, null);
      } else if (!loaded) {
        callback('enter your name!', null);
      } else {
        // if name is attached, is photo attached?
        isPhotoUploaded(dog, (err, uploaded) => {
          if (err) {
            callback(err, null);
          } else if (!uploaded) {
            callback('upload a photo!', null);
          } else {
            // are health records online?
            checkHealthRecords(dog, (err, available) => {
              if (err) {
                callback(err, null);
              } else if (!available) {
                callback('please upload your health records', null);
              } else {
                // is daily schedule online?
                isScheduleAttached(dog, (err, attached) => {
                  if (err) {
                    callback(err, null);
                  } else if (!attached) {
                    callback('add your daily schedule!', null);
                  } else {
                    callback(null, attached);
                  }
                })
              }
            })
          }
        })
      }
    })
  }