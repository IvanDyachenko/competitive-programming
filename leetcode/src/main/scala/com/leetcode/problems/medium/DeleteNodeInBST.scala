package com.leetcode.problems.medium

/** 450. Delete Node in a BST
  * https://leetcode.com/problems/delete-node-in-a-bst/
  */
object DeleteNodeInBST {

  sealed trait Tree[K, +V] {
    def key: K
    def value: V

    def delete(key: K)(implicit ord: Ordering[K]): Option[Tree[K, V]] = this match {
      case Node(k, v, lOpt, rOpt) if ord.lt(key, k) =>
        Some(Tree(k, v, lOpt.flatMap(_.delete(key)), rOpt))
      case Node(k, v, lOpt, rOpt) if ord.gt(key, k) =>
        Some(Tree(k, v, lOpt, rOpt.flatMap(_.delete(key))))
      case node @ Node(_, _, lOpt, Some(r))         =>
        val successor = node.successor.getOrElse(r)
        Some(Tree(successor.key, successor.value, lOpt, r.delete(successor.key)))
      case node @ Node(_, _, Some(l), rOpt)         =>
        val predecessor = node.predecessor.getOrElse(l)
        Some(Tree(predecessor.key, predecessor.value, l.delete(predecessor.key), rOpt))
      case leaf @ Leaf(k, _) if k != key            => Some(leaf)
      case _                                        => None

    }

    // The smallest node after the current one
    private[Tree] def successor: Option[Tree[K, V]] = this match {
      case Node(_, _, _, Some(right)) =>
        @annotation.tailrec
        def go(node: Tree[K, V]): Tree[K, V] = node match {
          case Node(_, _, Some(left), _) => go(left)
          case _                         => node
        }
        Some(go(right))
      case _                          => None
    }

    // The largest node before the current one
    private[Tree] def predecessor: Option[Tree[K, V]] = this match {
      case Node(_, _, Some(left), _) =>
        @annotation.tailrec
        def go(node: Tree[K, V]): Tree[K, V] = node match {
          case Node(_, _, _, Some(right)) => go(right)
          case _                          => node
        }
        Some(go(left))
      case _                         => None
    }
  }

  case class Leaf[K, +V](key: K, value: V) extends Tree[K, V]

  case class Node[K, +V](key: K, value: V, left: Option[Tree[K, V]], right: Option[Tree[K, V]]) extends Tree[K, V]

  object Tree {
    def apply[K, V](key: K, value: V, left: Option[Tree[K, V]], right: Option[Tree[K, V]]): Tree[K, V] =
      (left, right) match {
        case (None, None) => Leaf(key, value)
        case _            => Node(key, value, left, right)
      }

    def apply[V](value: V, left: Option[Tree[V, V]] = None, right: Option[Tree[V, V]] = None): Tree[V, V] =
      apply[V, V](value, value, left, right)
  }

}
