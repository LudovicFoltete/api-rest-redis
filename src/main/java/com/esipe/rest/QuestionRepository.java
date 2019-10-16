package com.esipe.rest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*This interface packs a punch given it supports
- Creating new instances
- Updating existing ones
- Deleting
- Finding (one, all, by simple or complex properties)
 */
@Repository
public interface QuestionRepository extends CrudRepository<Question, String> {

}
