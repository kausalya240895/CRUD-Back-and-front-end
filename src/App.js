import './App.css';
import StudentLists from './Components/StudentLists';
import Header from './Components/Header';
import Footer from './Components/Footer';
import { BrowserRouter,Routes,Route } from 'react-router-dom';
import AddStudent from './Components/AddStudent';

function App() {
  return (
    <div>
      <BrowserRouter>
      <Header/>
      <div className='container'>
        <Routes>
          <Route exact path='/' element={<StudentLists/>}></Route>
          <Route path='/students' element={<StudentLists/>}></Route>
          <Route path='/add-student' element={<AddStudent/>}></Route>
          <Route path='/edit-student/:id' element={<AddStudent/>}></Route>
          </Routes>
     </div>
     <Footer/>
     </BrowserRouter>
    </div>
  );
}

export default App;
