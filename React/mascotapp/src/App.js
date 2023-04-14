import './App.css';
import { Switch, Route, Routes } from "react-router-dom";
import Footer from './components/public/Footer';
import Main from './components/public/Main';
import Navbar from './components/public/Navbar';
import Detail from './components/public/Detail';
import UserFrom from './components/public/UserFrom';

function App() {              //App engloba componentes
  return (
    <div>
<Navbar />
{/* <Main /> */}
 <Routes>
   <Route exact path={"/"} element={<Main/>} />
   <Route path={"/details/:id"} element={<Detail/>}/>
   <Route path={"/user-form"} element={<UserFrom/>} />
</Routes> 
<Footer />

</div>

  );
}

export default App;
