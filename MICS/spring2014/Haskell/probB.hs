import Data.List (sort, intersperse, isPrefixOf)
import System.Environment (getArgs)

-- | author  : Joseph Ching
-- | run     : runhaskell probB.hs prob.in
-- assume missingH is not installed so write join and split manually.  From
-- there, it is just io and zipping left.

main :: IO ()
main = do args <- getArgs
          input <- readFile (head args)
          putStrLn (convert input)

-- | read, convert, sort, show
convert :: String -> String
convert = join "\n" . map show . oddEvenSort . intList
  where intList = map (\x -> read x :: Int) . init . split "\n"

-- | zip the even and odds numbers in the list
oddEvenSort :: [Int] -> [Int]
oddEvenSort [] = []
oddEvenSort xs = trailZip (head ls) (last ls)
  where ls     = zipWith filter [even, odd] . repeat . sort . init $ xs

-- | variation of zip that doens't cut off
trailZip :: [a] -> [a] -> [a]
trailZip []     []     = []
trailZip xs     []     = xs
trailZip []     ys     = ys
trailZip (x:xs) (y:ys) = x : y : trailZip xs ys

-- | join a list with a delimiter
join :: [a] -> [[a]] -> [a]
join d = concat . intersperse d

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
