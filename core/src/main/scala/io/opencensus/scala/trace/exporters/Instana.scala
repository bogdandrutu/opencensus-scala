package io.opencensus.scala.trace.exporters

import com.typesafe.scalalogging.LazyLogging
import io.opencensus.exporter.trace.instana.{
  InstanaExporterConfiguration,
  InstanaTraceExporter
}
import io.opencensus.scala.InstanaTraceExporterConfig

private[scala] object Instana extends LazyLogging {

  def init(config: InstanaTraceExporterConfig): Unit = {
    logger.info(
      s"Enabling InstanaTraceExporter with agent endpoint ${config.agentEndpoint}"
    )
    InstanaTraceExporter.createAndRegister(
      InstanaExporterConfiguration
        .builder()
        .setAgentEndpoint(config.agentEndpoint)
        .build()
    )
  }
}
