import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';
import { RobotDTO } from 'src/dto/robotdto';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class UserService extends AbstractService<UserDTO>{

  gateway: string = 'gateway';
  entityName : string = 'users';

  constructor(http: HttpClient) {
    super(http);
    this.type = 'user';
  }

  auth() {
    var user = JSON.parse(localStorage.getItem('Autoken')) as UserDTO;
    
    console.log("Service auth method: " + user);
    if(user) {
        return 'Bearer ' + user.authorities;
    } else {
        return "";
    }
  }

  login(loginDTO: LoginDTO): Observable<UserDTO> {
    return this.http.post<any>('http://localhost:8080/api/authenticate', loginDTO)
  }

  userLogged(username: string){
    console.log("Service user logged method: ", this.auth())
    return this.http.get('http://localhost:8080/api/users/'+username, {
      headers: {
          "Authorization": this.auth()
      }
    });
  }


  getAll(){
    return this.http.get<any>('http://localhost:' + this.port + '/api/' +this.entityName);
  }


  getUserByType(userType: String): Observable<UserDTO[]>{
    return this.http.get<any>('http://localhost:8080/' + this.type + '/getUser?userType='+userType)
  }

  insertRobot(robot: RobotDTO): Observable<any>
  {
    return this.http.post<any>('http://localhost:8080/'+ this.type + '/insertRobot', robot)
  }

  deleteRobot(robot: RobotDTO): Observable<any>
  {
    return this.http.post('http://localhost:8080/' + this.type + '/deleteRobot',robot);
  } 

}
