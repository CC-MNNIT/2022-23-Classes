const profileComplete = (dog) => {
  return isNameLoaded(dog)
    .then((dog) => {
      return isPhotoUploaded(dog);
    })
    .then((dog) => {
      return checkHealthRecords(dog);
    })
    .then((dog) => {
      return isScheduleAttached(dog);
    })
    .catch((err) => {
      return console.log("an error has occurred.");
    });
};
