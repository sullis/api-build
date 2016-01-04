/**
 * Generated by apidoc - http://www.apidoc.me
 * Service version: 0.9.51
 * apidoc:0.9.51 http://www.apidoc.me/bryzek/apidoc-generator/0.9.51/play_2_x_standalone_json
 */
package com.bryzek.apidoc.generator.v0.models {

  case class Error(
    code: String,
    message: String
  )

  /**
   * Represents a source file
   */
  case class File(
    name: String,
    dir: _root_.scala.Option[String] = None,
    contents: String
  )

  /**
   * The generator metadata.
   */
  case class Generator(
    key: String,
    name: String,
    language: _root_.scala.Option[String] = None,
    description: _root_.scala.Option[String] = None
  )

  case class Healthcheck(
    status: String
  )

  /**
   * The result of invoking a generator.
   */
  case class Invocation(
    source: String,
    files: Seq[com.bryzek.apidoc.generator.v0.models.File]
  )

  case class InvocationForm(
    service: com.bryzek.apidoc.spec.v0.models.Service,
    userAgent: _root_.scala.Option[String] = None
  )

}

package com.bryzek.apidoc.generator.v0.models {

  package object json {
    import play.api.libs.json.__
    import play.api.libs.json.JsString
    import play.api.libs.json.Writes
    import play.api.libs.functional.syntax._
    import com.bryzek.apidoc.common.v0.models.json._
    import com.bryzek.apidoc.generator.v0.models.json._
    import com.bryzek.apidoc.spec.v0.models.json._

    private[v0] implicit val jsonReadsUUID = __.read[String].map(java.util.UUID.fromString)

    private[v0] implicit val jsonWritesUUID = new Writes[java.util.UUID] {
      def writes(x: java.util.UUID) = JsString(x.toString)
    }

    private[v0] implicit val jsonReadsJodaDateTime = __.read[String].map { str =>
      import org.joda.time.format.ISODateTimeFormat.dateTimeParser
      dateTimeParser.parseDateTime(str)
    }

    private[v0] implicit val jsonWritesJodaDateTime = new Writes[org.joda.time.DateTime] {
      def writes(x: org.joda.time.DateTime) = {
        import org.joda.time.format.ISODateTimeFormat.dateTime
        val str = dateTime.print(x)
        JsString(str)
      }
    }

    implicit def jsonReadsApidocgeneratorError: play.api.libs.json.Reads[Error] = {
      (
        (__ \ "code").read[String] and
        (__ \ "message").read[String]
      )(Error.apply _)
    }

    implicit def jsonWritesApidocgeneratorError: play.api.libs.json.Writes[Error] = {
      (
        (__ \ "code").write[String] and
        (__ \ "message").write[String]
      )(unlift(Error.unapply _))
    }

    implicit def jsonReadsApidocgeneratorFile: play.api.libs.json.Reads[File] = {
      (
        (__ \ "name").read[String] and
        (__ \ "dir").readNullable[String] and
        (__ \ "contents").read[String]
      )(File.apply _)
    }

    implicit def jsonWritesApidocgeneratorFile: play.api.libs.json.Writes[File] = {
      (
        (__ \ "name").write[String] and
        (__ \ "dir").writeNullable[String] and
        (__ \ "contents").write[String]
      )(unlift(File.unapply _))
    }

    implicit def jsonReadsApidocgeneratorGenerator: play.api.libs.json.Reads[Generator] = {
      (
        (__ \ "key").read[String] and
        (__ \ "name").read[String] and
        (__ \ "language").readNullable[String] and
        (__ \ "description").readNullable[String]
      )(Generator.apply _)
    }

    implicit def jsonWritesApidocgeneratorGenerator: play.api.libs.json.Writes[Generator] = {
      (
        (__ \ "key").write[String] and
        (__ \ "name").write[String] and
        (__ \ "language").writeNullable[String] and
        (__ \ "description").writeNullable[String]
      )(unlift(Generator.unapply _))
    }

    implicit def jsonReadsApidocgeneratorHealthcheck: play.api.libs.json.Reads[Healthcheck] = {
      (__ \ "status").read[String].map { x => new Healthcheck(status = x) }
    }

    implicit def jsonWritesApidocgeneratorHealthcheck: play.api.libs.json.Writes[Healthcheck] = new play.api.libs.json.Writes[Healthcheck] {
      def writes(x: Healthcheck) = play.api.libs.json.Json.obj(
        "status" -> play.api.libs.json.Json.toJson(x.status)
      )
    }

    implicit def jsonReadsApidocgeneratorInvocation: play.api.libs.json.Reads[Invocation] = {
      (
        (__ \ "source").read[String] and
        (__ \ "files").read[Seq[com.bryzek.apidoc.generator.v0.models.File]]
      )(Invocation.apply _)
    }

    implicit def jsonWritesApidocgeneratorInvocation: play.api.libs.json.Writes[Invocation] = {
      (
        (__ \ "source").write[String] and
        (__ \ "files").write[Seq[com.bryzek.apidoc.generator.v0.models.File]]
      )(unlift(Invocation.unapply _))
    }

    implicit def jsonReadsApidocgeneratorInvocationForm: play.api.libs.json.Reads[InvocationForm] = {
      (
        (__ \ "service").read[com.bryzek.apidoc.spec.v0.models.Service] and
        (__ \ "user_agent").readNullable[String]
      )(InvocationForm.apply _)
    }

    implicit def jsonWritesApidocgeneratorInvocationForm: play.api.libs.json.Writes[InvocationForm] = {
      (
        (__ \ "service").write[com.bryzek.apidoc.spec.v0.models.Service] and
        (__ \ "user_agent").writeNullable[String]
      )(unlift(InvocationForm.unapply _))
    }
  }
}

