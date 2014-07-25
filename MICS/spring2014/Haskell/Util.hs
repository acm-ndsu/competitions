module Util (
    joinList
  , split
  )

where

import Data.List (intersperse, isPrefixOf)

-- | author : Joseph Ching
-- | bunch together all the utilies fuctions for these different problems

-- | joinList a list with a delimiter
joinList :: [a] -> [[a]] -> [a]
joinList d = concat . intersperse d

-- | splits a string with a delimiter
split :: Eq a => [a] -> [a] -> [[a]]
split _ [] = []
split d s =
  let (firstLine, remainder) = breakList (isPrefixOf d) s
  in  firstLine : case remainder of
                  [] -> []
                  x  -> if x == d
                        then [] : []
                        else split d (drop (length d) x)

-- | break up a list
breakList :: ([a] -> Bool) -> [a] -> ([a], [a])
breakList f = spanList (not . f)

-- | span over a list
spanList :: ([a] -> Bool) -> [a] -> ([a], [a])
spanList _ []        = ([], [])
spanList f ls@(x:xs) = if f ls
                       then (x:ys, zs)
                       else ([], ls)
                       where (ys, zs) = spanList f xs
