import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./Home";
import Create from "./Create";
import Update from "./Update";
import Read from "./Read";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />}>
          home
        </Route>
        <Route path="/create" element={<Create />} create></Route>
        <Route path="/update/:id" element={<Update />}>
          update
        </Route>
        <Route path="/read/:id" element={<Read />}>
          read
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
