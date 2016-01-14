package io.flow.lint.linters

import io.flow.lint.Linter
import com.bryzek.apidoc.spec.v0.models.{Field, Model, Service}

/**
  * For well known field names, enforce specific types to ensure
  * consistency. For example, all fields named 'id' or 'name' must be
  * strings.
  */
case object CommonFieldTypes extends Linter with Helpers {

  val Expected = Map(
    "id" -> "string",
    "guid" -> "uuid",
    "name" -> "string",
    "email" -> "string"
  )

  override def validate(service: Service): Seq[String] = {
    service.models.flatMap(validateModel(service, _))
  }

  def validateModel(service: Service, model: Model): Seq[String] = {
    model.fields.flatMap(validateFieldType(service, model, _))
  }

  def validateFieldType(service: Service, model: Model, field: Field): Seq[String] = {
    Expected.get(field.name) match {
      case None => {
        Nil
      }
      case Some(exp) => {
        exp == field.`type` match {
          case true => {
            Nil
          }
          case false => {
            Seq(error(model, field, s"Type must be '$exp' and not ${field.`type`}"))
          }
        }
      }
    }
  }

}