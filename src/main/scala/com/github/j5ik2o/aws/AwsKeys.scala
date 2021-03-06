package com.github.j5ik2o.aws

import com.amazonaws.regions.Regions
import com.amazonaws.services.elasticbeanstalk.model.{OptionSpecification, ConfigurationOptionSetting, ApplicationVersionDescription, ApplicationDescription}
import com.amazonaws.services.s3.model.ObjectMetadata
import sbt._

trait AwsKeys {

  lazy val aws = TaskKey[Unit]("aws")

  lazy val region = SettingKey[Regions]("region")

  lazy val credentialProfileName = SettingKey[String]("credential-profile-name")

}

trait EBKeys {

  lazy val ebApplicationName = SettingKey[String]("eb-application-name")

  lazy val ebApplicationDescription = SettingKey[Option[String]]("eb-application-desc")

  lazy val ebVersionLabel = SettingKey[String]("eb-version-label")

  lazy val ebTemplateName = SettingKey[String]("eb-template-name")

  lazy val ebTemplates = SettingKey[Seq[EbConfigurationTemplate]]("eb-templates")

  lazy val ebCreateApplication = TaskKey[ApplicationDescription]("create-application")

  lazy val ebCreateApplicationVersion = TaskKey[ApplicationVersionDescription]("create-application-version")

}

case class EbConfigurationTemplate
(name: String, description: String,
 solutionStackName: String,
 optionSettings: Seq[ConfigurationOptionSetting],
 optionsToRemoves: Seq[OptionSpecification],
 recreate: Boolean
)

trait S3Keys {

  lazy val s3BucketName = SettingKey[String]("s3-bucket-name")

  lazy val s3Key = SettingKey[String]("s3-key")

  lazy val s3File = SettingKey[File]("s3-file")

  lazy val s3ObjectMetadata = SettingKey[Option[ObjectMetadata]]("s3-object-metadata")

  lazy val s3OverwriteObject = SettingKey[Boolean]("s3-overwrite-object", "Overwrite file on S3.")

  lazy val s3Upload = TaskKey[Option[String]]("s3-upload", "Uploads files to an S3 bucket.")

}

object AwsKeys extends AwsKeys {
  object EBKeys extends EBKeys
  object S3Keys extends S3Keys
}


