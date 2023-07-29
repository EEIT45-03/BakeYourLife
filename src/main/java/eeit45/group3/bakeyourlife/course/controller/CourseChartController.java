package eeit45.group3.bakeyourlife.course.controller;

import eeit45.group3.bakeyourlife.course.repository.CourseRepository;
import eeit45.group3.bakeyourlife.course.repository.ProductRepositry;
import eeit45.group3.bakeyourlife.course.repository.RegisterRepository;
import eeit45.group3.bakeyourlife.course.repository.StudentResultRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseChartController {

  private final CourseRepository courseRepository;
  private final ProductRepositry productRepositry;
  private final RegisterRepository registerRepository;
  private final StudentResultRepository studentResultRepository;

  @Autowired
  public CourseChartController(
      CourseRepository courseRepository,
      ProductRepositry productRepositry,
      RegisterRepository registerRepository,
      StudentResultRepository studentResultRepository) {
    this.courseRepository = courseRepository;
    this.productRepositry = productRepositry;
    this.registerRepository = registerRepository;
    this.studentResultRepository = studentResultRepository;
  }

  //    @GetMapping("/RegisterCount")
  //    public CourseChart findRegisterCount() {
  //        CourseChart courseChart = new CourseChart();
  //        List<CourseChart> courseChartList = registerRepository.getSumAttendanceByCourse();
  //        for (CourseCount data : courseCountList) {
  //            goodsChart.addData(data);
  //        }
  //        return courseChart;
  //    }

}
