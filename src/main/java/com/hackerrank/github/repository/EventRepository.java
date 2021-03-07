package com.hackerrank.github.repository;

import com.hackerrank.github.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("select e from Event e where e.repo.id=?1 order by e.id")
    List<Event> findByRepoId(long repoId);

    @Query("select e from Event e where e.actor.id=?1 order by e.id")
    List<Event> findByActorId(long actorId);

    @Query("select e from Event e where e.repo.id=?1 and e.actor.id =?2 order by e.id")
    List<Event> findByRepoIdAndActorId(long repoId, long actorId);

}