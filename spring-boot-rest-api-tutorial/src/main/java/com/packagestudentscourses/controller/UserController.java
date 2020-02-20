package com.packagestudentscourses.controller;
import com.packagestudentscourses.model.Course;
import com.packagestudentscourses.model.Lecturer;
import com.packagestudentscourses.model.Student;
import com.packagestudentscourses.model.User;
import com.packagestudentscourses.repository.CourseRepository;
import com.packagestudentscourses.repository.UserRepository;
import com.packagestudentscourses.exception.ResourceNotFoundException;
import com.packagestudentscourses.repository.LecturerRepository;
import com.packagestudentscourses.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type User controller.
 *
 * @author Chen Kashi
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private LecturerRepository lecturerRepository;

  @Autowired
  private CourseRepository courseRepository ;

//  /**
//   * Get all users list.
//   *
//   * @return the list
//   */
//  @GetMapping("/users")
//  public List<User> getAllUsers() {
//    return (List<User>) userRepository.findAll();
//  }

//  /**
//   * Get all users list.
//   *
//   * @return the list
//   */
  @GetMapping("/getStudents")
  public List<Student> getAllStudents() {
    List<Student> all = (List<Student>) studentRepository.findAll();
    return all;
  }


  @GetMapping("/getCourses")
  public List<Course> getAllCourses() {
    List<Course> all = (List<Course>) courseRepository.findAll();
    return all;
  }
//
//  /**
//   * Gets users by id.
//   *
//   * @param userId the user id
//   * @return the users by id
//   * @throws ResourceNotFoundException the resource not found exception
//   */
  @GetMapping("/getStudentBy/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long userId)
      throws ResourceNotFoundException {
    Student user =
        studentRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found on :: " + userId));
    return ResponseEntity.ok().body(user);
  }

  /**
   * Create Student student.
   *
   * @param Student the student
   * @return the student
   */
  @PostMapping("/createStudent")
  public Student createStudent(@Valid @RequestBody Student user) throws ResourceNotFoundException {

    if(studentRepository.findById(user.getId()).isPresent()){
      throw new ResourceNotFoundException("Student already exist on id ( you cant add him again) :: " + user.getId());
    }
    return studentRepository.save(user);
  }



  /**
   * Create Lecture lecturer.
   *
   * @param Lecture the lecturer
   * @return lecturer
   */
  @PostMapping("/createLecturer")
  public Lecturer createLecturer(@Valid @RequestBody Lecturer user) throws ResourceNotFoundException {


    if(lecturerRepository.findById(user.getId()).isPresent()){
      throw new ResourceNotFoundException("Lecturer already exist on id ( you cant add him again) :: " + user.getId());
    }
    return lecturerRepository.save(user);



  }

  /**
   * Create Course Course.
   *
   * @param Course
   * @return Course
   */
  @PostMapping("/createCourse")
  public Course createCourse(@Valid @RequestBody Course course) {

    return courseRepository.save(course);
  }

//  /**
//   * Create user user.
//   *
//   * @param user the user
//   * @return the user
//   */
//  @PostMapping("/users")
//  public User createUser(@Valid @RequestBody User user) {
//    return userRepository.save(user);
//  }




//  /**
//   * Update user response entity.
//   *
//   * @param userId the user id
//   * @param userDetails the user details
//   * @return the response entity
//   * @throws ResourceNotFoundException the resource not found exception
//   */
//  @PutMapping("/users/{id}")
//  public ResponseEntity<User> updateUser(
//      @PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails)
//      throws ResourceNotFoundException {
//
//    User user =
//        userRepository
//            .findById(userId)
//            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
//
//    user.setEmail(userDetails.getEmail());
//    user.setLastName(userDetails.getLastName());
//    user.setFirstName(userDetails.getFirstName());
//    final User updatedUser = userRepository.save(user);
//    return ResponseEntity.ok(updatedUser);
//  }
  @PutMapping("/updateStudent/{id}")
  public ResponseEntity<Student> updateStudent(
          @PathVariable(value = "id") Long userId, @Valid @RequestBody Student userDetails)
          throws ResourceNotFoundException {

    Student user =
            studentRepository
                    .findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

    user.setEmail(userDetails.getEmail());
    user.setLastName(userDetails.getLastName());
    user.setFirstName(userDetails.getFirstName());
    final Student updatedUser = studentRepository.save(user);
    return ResponseEntity.ok(updatedUser);
  }
  /**
   * Delete user map.
   *
   * @param userId the user id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping("/deleteStudentBy/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
    Student user =
        studentRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found on :: " + userId));

    studentRepository.delete(user);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
