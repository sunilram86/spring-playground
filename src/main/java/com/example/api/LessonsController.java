package com.example.api;

import com.example.database.LessonRepository;
import com.example.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all()
    {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson){
        return this.repository.save(lesson);
    }

    @GetMapping("/{index}")
    public Lesson findTitlebyID(@PathVariable Long index)
    {
        System.out.println("index"+index);
        System.out.println(this.repository.findOne(index));


        Lesson lesson= this.repository.findOne(index);
        System.out.println(lesson);
        return lesson;


    }


    @PatchMapping("/{index}")
    public Lesson updateTitlebyID(@PathVariable Long index,@RequestBody Lesson lesson1)
    {
        System.out.println("index"+index);

        Lesson lesson= this.repository.save(lesson1);
        System.out.println(lesson);
        return lesson;

    }

    @DeleteMapping("/{index}")
    public void deleteTitlebyID(@PathVariable Long index)
    {
        System.out.println("index"+index);
        this.repository.delete(index);

    }


}
