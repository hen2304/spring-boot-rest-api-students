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
  private StudentRepository studentRepository;

  @Autowired
  private LecturerRepository lecturerRepository;

  @Autowired
  private CourseRepository courseRepository ;

  @GetMapping("/getStudents")
  public List<StudentEntity> getAllStudents() {


    List<StudentEntity> all = (List<StudentEntity>) studentRepository.findAll();
    return all;
  }


  @GetMapping("/getCourses")
  public List<CourseEntity> getAllCourses() {
    List<CourseEntity> all = (List<CourseEntity>) courseRepository.findAll();
    return all;
  }


  @GetMapping("/getStudentBy/{id}")
  public ResponseEntity<StudentEntity> getStudentById(@PathVariable(value = "id") Long userId)
      throws ResourceNotFoundException {
    StudentEntity user =
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
  public StudentEntity createStudent(@Valid @RequestBody StudentEntity user) throws ResourceNotFoundException {

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
  public LecturerEntity createLecturer(@Valid @RequestBody LecturerEntity user) throws ResourceNotFoundException {


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
  public CourseEntity createCourse(@Valid @RequestBody CourseEntity course) {

    return courseRepository.save(course);
  }


  @PutMapping("/updateStudent/{id}")
  public ResponseEntity<StudentEntity> updateStudent(
          @PathVariable(value = "id") Long userId, @Valid @RequestBody StudentEntity userDetails)
          throws ResourceNotFoundException {

    StudentEntity user =
            studentRepository
                    .findById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

    user.setLastName(userDetails.getLastName());
    user.setFirstName(userDetails.getFirstName());
    final StudentEntity updatedUser = studentRepository.save(user);
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
    StudentEntity user =
        studentRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found on :: " + userId));

    studentRepository.delete(user);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
