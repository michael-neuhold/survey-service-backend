package clc.shared

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.hibernate.Hibernate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "USER_INFO")
data class User(val userName: String,
                val firstName: String,
                val lastName: String,
                val email: String,
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                val id: Long? = null) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as User

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }

}
