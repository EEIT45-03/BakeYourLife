package eeit45.group3.bakeyourlife.course.controller;

import eeit45.group3.bakeyourlife.course.repository.CourseRepository;
import eeit45.group3.bakeyourlife.course.repository.ProductRepositry;
import eeit45.group3.bakeyourlife.course.repository.RegisterRepository;
import eeit45.group3.bakeyourlife.course.repository.StudentResultRepository;
import eeit45.group3.bakeyourlife.course.util.CourseChart;
import eeit45.group3.bakeyourlife.course.util.CourseCount;
import eeit45.group3.bakeyourlife.good.utils.GoodsChart;
import eeit45.group3.bakeyourlife.good.utils.GoodsCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class CourseChartController {

    private final CourseRepository courseRepository;
    private final ProductRepositry productRepositry;
    private final RegisterRepository registerRepository;
    private final StudentResultRepository studentResultRepository;

    @Autowired
    public CourseChartController(CourseRepository courseRepository, ProductRepositry productRepositry, RegisterRepository registerRepository, StudentResultRepository studentResultRepository) {
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
