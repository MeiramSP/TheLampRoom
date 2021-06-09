package kz.saparov.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kz.saparov.room.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	
	@Modifying(clearAutomatically = true)
	@Query("update Room r set r.ligthOn= :ligth where r.id = :id")
	int changeRoomLigth(@Param("id") Long id,@Param("ligth") Boolean ligth);

}
