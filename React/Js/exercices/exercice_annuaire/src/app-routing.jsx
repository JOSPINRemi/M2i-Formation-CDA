import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import ErrorPage from "./routes/ErrorPage";
import HomePage from "./routes/HomePage";
import ContactsListPage from "./routes/ContactsListPage";
import ContactPage from "./routes/ContactPage";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "/",
        element: <HomePage />,
      },
      {
        path: "/contacts",
        element: <ContactsListPage />,
      },
      {
        path: "/contact/:action",
        element: <ContactPage />,
      },
      {
        path: "/contact/:action/:id",
        element: <ContactPage />,
      },
    ],
  },
]);

export default router;
