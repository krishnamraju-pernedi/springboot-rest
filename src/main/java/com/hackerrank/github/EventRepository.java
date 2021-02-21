package com.hackerrank.github;

import com.hackerrank.github.entity.EventEntity;
import com.hackerrank.github.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    @Query("select e from EventEntity e where e.repoId=?1 order by e.id")
    List<EventEntity> findByRepoId(long repoId);


    @Query("select e from EventEntity e where e.actorId=?1 order by e.id")
    List<EventEntity> findByActorId(long actorId);

    @Query("select e from EventEntity e where e.repoId=?1 and e.actorId =?2 order by e.id")
    List<EventEntity> findByRepoIdAndActorId(long repoId, long actorId);




}
