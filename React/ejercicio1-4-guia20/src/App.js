import logo from './logo.svg';
import './App.css';
import Ejemplo from './App/Ejemplo';
import Footer from './App/Footer';
import Main from './App/Main';
import Main2 from './App/Main2';
import Navbar from './App/Navbar';
import Hijo from './App/Hijo';
import {Switch, Route, Routes} from 'react-router-dom';


function App() {
  return (

<div>
<Navbar />
<Routes>
<Route exact path='Main' element={<Main />} />
<Route exact path='Main2' element={<Main2 />} />
</Routes>
<Footer />
</div>
  );
}

export default App;
