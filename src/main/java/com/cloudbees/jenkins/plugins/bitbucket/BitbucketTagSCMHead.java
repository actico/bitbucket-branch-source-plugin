package com.cloudbees.jenkins.plugins.bitbucket;

import com.cloudbees.jenkins.plugins.bitbucket.api.BitbucketRepositoryType;

import edu.umd.cs.findbugs.annotations.CheckForNull;
import edu.umd.cs.findbugs.annotations.NonNull;
import jenkins.plugins.git.GitTagSCMHead;
import jenkins.scm.api.mixin.TagSCMHead;

public class BitbucketTagSCMHead extends GitTagSCMHead implements TagSCMHead
{

   /**
    * Cache of the repository type. Will only be {@code null} for data loaded from pre-2.1.0 releases
    *
    * @since 2.1.0
    */
   // The repository type should be immutable for any SCMSource.
   @CheckForNull
   private final BitbucketRepositoryType repositoryType;

   /**
    * Constructor.
    *
    * @param branchName     the branch name
    * @param repositoryType the repository type.
    */
   public BitbucketTagSCMHead(String branchName, long timestamp, BitbucketRepositoryType repositoryType)
   {
      super(branchName, timestamp);
      this.repositoryType = repositoryType;
   }

   /**
    * Constructor.
    *
    * @param name      the name.
    * @param timestamp the tag timestamp;
    */
   public BitbucketTagSCMHead(@NonNull String name, long timestamp)
   {
      this(name, timestamp, BitbucketRepositoryType.GIT);
   }

   /**
    * Gets the repository type.
    * @return the repository type or {@code null} if this is a legacy branch instance.
    */
   @CheckForNull
   public BitbucketRepositoryType getRepositoryType()
   {
      return repositoryType;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String getPronoun()
   {
      return Messages.BitBucketTagSCMHead_Pronoun();
   }

}
