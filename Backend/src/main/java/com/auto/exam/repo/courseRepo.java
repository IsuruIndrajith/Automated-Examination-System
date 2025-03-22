package com.auto.exam.repo;

import com.auto.exam.Dto.CoursesForLecture;
import com.auto.exam.Model.Course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRepo extends JpaRepository<Course,Long> {
    @Query("SELECT new com.auto.exam.Dto.CoursesForLecture(c.courseId, c.courseName, c.courseCode, c.credits, co.offeringId)"+
            " FROM Course c JOIN c.courseOfferings co JOIN co.lecture l JOIN l.staff s JOIN s.user u WHERE u.username = :user_name")
    List<CoursesForLecture> findCourseByLectureName(@Param("user_name") String user_name);
}
