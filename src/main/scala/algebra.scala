// Copyright: 2017 https://github.com/fommil/drone-dynamic-agents/graphs
// License: http://www.gnu.org/licenses/gpl-3.0.en.html
package algebra

import java.lang.String
import java.time.ZonedDateTime

import scala.Int
import scala.collection.immutable.Map
import scala.language.higherKinds

import scalaz.NonEmptyList

trait Drone[F[_]] {
  def getBacklog: F[Int]
  def getAgents: F[Int]
}

final case class MachineNode(id: String)

trait Machines[F[_]] {
  def getTime: F[ZonedDateTime]
  def getManaged: F[NonEmptyList[MachineNode]]
  def getAlive: F[Map[MachineNode, ZonedDateTime]]
  def start(node: MachineNode): F[MachineNode]
  def stop(node: MachineNode): F[MachineNode]
}
