package com.example.earlysoccerserver.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
abstract class AuditDateTimeEntity: AuditIDEntity() {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected var createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column()
    protected lateinit var updatedAt: LocalDateTime
}

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
abstract class AuditIDEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected var id: Long? = null
}