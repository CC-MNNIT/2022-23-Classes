// const foo = () => {
//   connectDatabase().then((database) => {
//     return findAllBooks(database).then((books) => {
//       return getCurrentUser(database).then((user) => {
//         return pickTopRecommendation(books, user);
//       });
//     });
//   });
// };

const foo1 = async () => {
  const database = await connectDatabase();
  const books = await findAllBooks(database);
  const user = await getCurrentUser(database);
  const topRecommendation = await pickTopRecommendation(books, user);
  return topRecommendation;
};

const foo2 = async () => {
  const database = await connectDatabase();
  const books = await findAllBooks(database);
  const user = await getCurrentUser(database);
  const topRecommendation = await pickTopRecommendation(books, user);
  return topRecommendation;
};

foo();
