import Data.List (sort)
import System.Environment (getArgs)
import Util (joinList, split)

-- | author  : Joseph Ching
-- | run     : runhaskell probB.hs prob.in
-- | assume missingH is not installed so write joinList and split manually.  From
--   there, it is just io and zipping left.

main :: IO ()
main = do args <- getArgs
          input <- readFile (head args)
          putStrLn (convert input)

-- | read, convert, sort, show
convert :: String -> String
convert = joinList "\n" . map show . oddEvenSort . intList
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
